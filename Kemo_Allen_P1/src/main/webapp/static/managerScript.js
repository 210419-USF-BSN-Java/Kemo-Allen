document.getElementById('pending').onclick = getPendingM;
document.getElementById('resolved').onclick = getResolvedM;
document.getElementById('employees').onclick = getEmployees;
document.getElementById('viewEmp').onclick = createReimbSearch;
document.getElementById('getEmpReimb').onclick = viewEmployeeReimb;

function createReimbSearch(){
    let body = document.getElementById('body');
    body.innerHTML = 
    `<form action="../manager/viewEmployeeReimbursement" id="empSearch" method="POST">
        <label for="empId">Enter Employee ID</label>
        <input type="number" id="empId" name="empId" min="0" required>
        <button type="submit" id="getEmpReimb">Get Reimbursements</button>
    </form>
    `
}

async function viewEmployeeReimb(){ //Not Applicable?
    apiURL = 'http://localhost:8080/manager/viewEmployeeReimbursement';
    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayEmployeeReimb(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error Get Employee Data  </p>`
    }
}

async function getPendingM(){
    apiURL = 'http://localhost:8080/manager/viewPending';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayPending(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Pending  </p>`
    }
}

async function getResolvedM(){
    apiURL = 'http://localhost:8080/manager/viewResolved';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayResolved(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Resolved  </p>`
    }
}

async function getEmployees(){
    apiURL = 'http://localhost:8080/manager/viewEmployees';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayEmployees(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error View Employees  </p>`
    }
}

function displayEmployees(response){
    let body = document.getElementById('body');

    while(body.firstChild){
        body.removeChild(body.firstChild);
    }
    
    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} UserName:  ${obj.userName} `;
        body.appendChild(p);
    }

    // let button = document.createElement('button');
    // button.setAttribute("type", "button");
    // button.setAttribute("id", "getEmpReimb");
    // button.innerText("Get Employee Reimbursements");
    // body.appendChild(button);
}

function displayPending(response){
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

function displayResolved(response){
    let body = document.getElementById('body');
   
    //Clear old display
    while(body.firstChild){
        body.removeChild(body.firstChild);
    }

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
        var p = document.createElement('p');
        p.textContent = `ID: ${obj.id} Status: ${obj.reimbStatus} Amount:  ${obj.reimbAmount} 
                           Time Sent:  ${obj.reimbSubmitted} Time Resolved: ${obj.reimbResolved}
                            Description:  ${obj.reimbDescription} Resolver: ${obj.resolver}`;
        body.appendChild(p);
    }
}

function displayEmployeeReimb(response){
    let body = document.getElementById('body');
    let sibling = document.getElementById('empSearch');

    //Clear old display
    while(sibling.nextElementSibling){
        sibling.sibling(sibling.nextElementSibling);
    }

    if(response != null){
        for(var i = 0; i < response.length; i++){
            var obj = response[i];
            // document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
            var p = document.createElement('p');
            p.textContent = `ID: ${obj.id} Status:  ${obj.reimbStatus} Amount:  ${obj.reimbAmount} 
                            Time Sent:  ${obj.reimbSubmitted} Description:  ${obj.reimbDescription}`;
            body.appendChild(p);
        }
    }
    else{
        var p = document.createElement('p');
        p.textContent = `That user doesn't have any reimbursements right now.`;
        body.appendChild(p);
    }
}

// function createEmployeeDropDown(response){
//     let body = document.getElementById('body2');
//     let dropDown = document.createElement('select');
//     let button = document.createElement('button');

//     while(body.firstChild){
//         body.removeChild(body.firstChild);
//     }

//     for(var i = 0; i < response.length; i++){
//         var option = document.createElement('option');
//         var obj = response[i];

//         option.value = obj.id;
//         option.textContent = obj.userName;

//         dropDown.appendChild(option);
//     }

//     button.setAttribute("type", "button");
//     button.setAttribute("id", "getEmpReimb");
//     button.innerText("Get Employee Reimbursements");

//     body.appendChild(dropDown);
//     body.appendChild(button);
// }