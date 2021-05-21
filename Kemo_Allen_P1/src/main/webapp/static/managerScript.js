document.getElementById('pending').onclick = getPendingM;
document.getElementById('resolved').onclick = getResolvedM;
document.getElementById('employees').onclick = getEmployees;

async function getPendingM(){
    apiURL = 'http://localhost:8080/manager/viewPending';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimbM(data);
    }else{
        document.getElementById('body2').innerHTML = `<p> Error View Pending  </p>`
    }
}

async function getResolvedM(){
    apiURL = 'http://localhost:8080/manager/viewResolved';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimbM(data);
    }else{
        document.getElementById('body2').innerHTML = `<p> Error View Resolved  </p>`
    }
}

async function getEmployees(){
    apiURL = 'http://localhost:8080/manager/viewEmployees';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayEmployees(data);
    }else{
        document.getElementById('body2').innerHTML = `<p> Error View Employees  </p>`
    }
}

function displayEmployees(response){
    let body = document.getElementById('body2');
   
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
}

function displayReimbM(response){
    let body = document.getElementById('body2');
   
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