

document.getElementById('profile').onclick = getProfile;
// document.getElementById('profile').onclick = displayProfile;

document.getElementById('viewPending').onclick = getReimb('http://localhost:8080/ERS/employee/viewPending');

async function getProfile(){
    let apiURL = 'http://localhost:8080/ERS/employee/profile';
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayProfile(data);
        //displayProfile();
    }else{
        document.getElementById('body').innerHTML = `<p> Error </p>`
    }
}

async function getReimb(apiURL){
	let response = await fetch(apiURL);
	
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        displayReimb(data);
    }else{
        document.getElementById('body').innerHTML = `<p> Error </p>`
    }
}

function displayProfile(response){
    // let input = document.createElement('input');
    // input.defaultValue = 'Works';
    // document.getElementById('body').appendChild(input);

	document.getElementById('body').innerHTML = `<p> Works ${response.userName}</p>`
	
}

function displayProfile(){
    document.getElementById('body').innerHTML =
     `<label>User Name: </label>
        <input type='text' value ='Works'></input>`

}

function displayReimb(response){

    for(var i = 0; i < response.length; i++){
        var obj = response[i];
        document.getElementById('body').innerHTML = `<p>${obj.id}</p>`
    }
}