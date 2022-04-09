let landingEmail='' ;
let emailList = [];

function getLandingEmail(){
    landingEmail= document.getElementById("landingemail").value;
    emailList.push(landingEmail);
    alert("subscribe cfm")
    document.getElementById("landingemail").value = ""
     console.log(emailList)


}






