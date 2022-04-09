
let enquiryForms=[];
function getForm(){
   let custname = document.getElementById("custname").value;
   let custemail = document.getElementById("custemail").value;
   let custnum = document.getElementById("custnum").value
   let custmsg= document.getElementById("custmsg").value;

   let data = formData(custname,custemail,custnum,custmsg)
   enquiryForms.push(data)
   console.log(enquiryForms)
}


 function formData(custname,email,phone,message) {
     let data={
    "cname" : custname,
    "email" : email,
    "phone" : phone,
    "cmessage" : message
     }
     
     return data
}



