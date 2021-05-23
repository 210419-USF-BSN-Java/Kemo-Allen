document.getElementById('profile').onclick = getProfile;

document.getElementById('viewPending').onclick = getPending;// () calls fucnction without event

document.getElementById('viewResolved').onclick = getResolved;

document.getElementById('createForm').onclick = createForm;

document.getElementById('submitForm').onclick= submitForm;

document.getElementById('updateProfile').onclick= updateProfile;
//document.getElementById('profile').onclick = testClick;

// let create = document.getElementById('submitForm');
// create.addEventListener('click', testSubmit, false);

function testClick(){
        var p = document.createElement('p');
        p.innerHTML = 'Hello';
        document.getElementById('body').appendChild(p);
}

function createForm(){
    let body = document.getElementById('body');
    body.innerHTML = ` 
    <form action="../employee/submitForm" method="POST">
        <h4>Enter Reimbursement Info </h4>
        <label for="type">Type</label>
        <select name="type" id="type" required>
            <option value="1">Lodging</option>
            <option value="2">Food</option>
            <option value="3">Other</option>
        </select>
        <br>
        <label for="amount">Amount: </label>
        <input type="number" id="amount" name="amount" class="form-control" min="0" max="10000" required>
        <label for="desc">Description:</label>
        <input type="text" id="desc" name="desc" class="form-control" maxlength="200">
        
        <button type ="submit" id="submitForm">Submit Reimbursement</button>
    </form>
    `
}

async function submitForm(){
    apiURL = 'http://localhost:8080/employee/submitForm';
    // let reimb ={
    //     type: document.getElementById('type'),
    //     amount: document.getElementById('amount'),
    //     desc: document.getElementById('desc')
    // };

	// let response = await fetch(apiURL, {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json;charset=utf-8'
    //       },
    //       body: JSON.stringify(reimb)
    // });

    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        document.getElementById('body').innerHTML = `<p> Submitted Successfully </p>`
        
    }else{  
        document.getElementById('body').innerHTML = `<p> Error submitting reimbursement </p>`
    }
}

async function getProfile(){
    let apiURL = 'http://localhost:8080/employee/profile';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayProfile(data);
        //displayProfile();
    }else{
        document.getElementById('body').innerHTML = `<p> Error Profile. </p>`
    }
}

async function updateProfile(){
    let apiURL = 'http://localhost:8080/employee/updateProfile';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        document.getElementById('body').innerHTML = `<p> Uodated Profile. </p>`
    }else{
        document.getElementById('body').innerHTML = `<p> Error Update Profile. </p>`
    }
}

async function getPending(){
    apiURL = 'http://localhost:8080/employee/viewPending';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimb(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

async function getResolved(){
    apiURL = 'http://localhost:8080/employee/viewResolved';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimb(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

function displayProfile(response){
    document.getElementById('body').innerHTML =
     `<label>User Name: </label> <input type='text' value ='${response.userName}'></input>
     <br>
     <label>First Name: </label> <input type='text' id="firstName" name="firstName" value ='${response.firstName}'></input>
     <br>
     <label>Last Name: </label> <input type='text' id="lastName"  name="lastName" value ='${response.lastName}'></input>
     <br>
     <form action"../employee/updateProfile" method="POST">
        <button type="submit" id="updateProfile">Update Profile</button>
     </form>
     `

}

function displayReimb(response){
    let body = document.getElementById('body');
    let br = document.createElement('br');

    //Clear old display
    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} 
                        Status:  ${obj.reimbStatus} 
                        Amount:  ${obj.reimbAmount} 
                        Time Sent:  ${obj.reimbSubmitted} 
                        Description:  ${obj.reimbDescription}`;
        body.appendChild(p);
    }
}