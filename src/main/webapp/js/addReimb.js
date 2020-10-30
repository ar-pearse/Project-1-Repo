async function addReimbursement(){
    const reimb = {
        amount: parseFloat(document.getElementById("amount").value),
        description: document.getElementById("description").value,
        type: parseInt(document.getElementById("type").value),
    }

    console.log(JSON.stringify(reimb));

    await fetch('http://3.20.226.235:8081/AmatuerPhotoshop-0.0.1-SNAPSHOT/reimb.json', {
        method: 'post',
        body: JSON.stringify(reimb)
    });

}

document.getElementById("create").addEventListener('click', addReimbursement);