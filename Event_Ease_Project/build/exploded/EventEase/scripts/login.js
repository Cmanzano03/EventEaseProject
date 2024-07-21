function myFunction(){
    
    var id = document.getElementById("id");
    var password = document.getElementById("password");
    var form = document.getElementById("form");
    
    if(id.value.length == 0 || password.value.length == 0){
            return
    }

    //Enviamos los campos
    form.submit();
    
}