function click_add(){
    // var id = document.getElementById("uid").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var sex = document.getElementById("sex").value;
    var position = document.getElementById("position").value;
    var telephoneNum = document.getElementById("telephoneNum").value;
    // alert(JSON.stringify({"username":username, "password":password, "email":email, "sex":sex, "position":position, "telephoneNum":telephoneNum}));
    $.ajax({
        type:'post', 
        url:'http://localhost:8090/api/page/ui/user/add/eject',
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"username":username, "password":password, "email":email,
        "sex":sex, "position":position, "telephoneNum":telephoneNum}),
        // data:JSON.stringify({"id":1,"username":"username", "password":"password", "email":"email",
        // "sex":"sex", "position":"position", "telephoneNum":"telephoneNum"}),
        dataType:"json",
        success: function(){
          console.log("success");
        }
      }
    );
  };
  function click_save(id){
    var id = document.getElementById("uid").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var sex = document.getElementById("sex").value;
    var position = document.getElementById("position").vaule;
    var telephoneNum = document.getElementById("telephoneNum").value;
    // alert(JSON.stringify({"id":id, "username":username, "password":password, "email":email, "sex":sex, "position":position, "telephoneNum":telephoneNum}));
    $.ajax({
        type:'post', 
        url:'http://localhost:8090/api/page/ui/user/update/eject',
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({"id":id,"username":username, "password":password, "email":email,
        "sex":sex, "position":position, "telephoneNum":telephoneNum}),
        // data:JSON.stringify({"id":1,"username":"username", "password":"password", "email":"email",
        // "sex":"sex", "position":"position", "telephoneNum":"telephoneNum"}),
        dataType:"json",
        success: function(){
          console.log("success");
        }
      }
    );
  };
  function getTest(){
    $.ajax({type:"GET",url:"http://localhost:8090/api/ajax/get-test?",data:"id=1",
        async: true,
        cache: false,
        dataType: "json",
        success: function(data){
          console.log("success");
        },
        error: function(){
          console.log("error");
        },
        complete: function(){
          console.log("finished");
        }
      }
    );
  };
  function click_query(){
      var username = document.getElementById("username-query").value;
      window.location.href="http://localhost:8090/api/page/ui/user/query?username="+username;
  }