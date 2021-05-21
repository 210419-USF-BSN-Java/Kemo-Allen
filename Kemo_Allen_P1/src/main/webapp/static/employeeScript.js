

//document.getElementById('profile').onclick = getProfile;
document.getElementById('profile').onclick = getProfile;

document.getElementById('viewPending').onclick = getPending;// () calls fucnction without event

document.getElementById('viewResolved').onclick = getResolved;
//document.getElementById('profile').onclick = testClick;

function testClick(){
        var p = document.createElement('p');
        p.innerHTML = 'Hello';
        document.getElementById('body').appendChild(p);
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
     <label>First Name: </label> <input type='text' value ='${response.firstName}'></input>
     <label>Last Name: </label> <input type='text' value ='${response.lastName}'></input>
     `

}

function displayReimb(response){
    let body = document.getElementById('body');
   
    //Clear old display
    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} Status:  ${obj.reimbStatus} Amount:  ${obj.reimbAmount} 
                           Time Sent:  ${obj.reimbSubmitted} Description:  ${obj.reimbDescription}`;
        body.appendChild(p);
    }
}