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
  function click_save(){
    var id = document.getElementById("uid").value;
    var username = document.getElementById("username-edit").value;
    var password = document.getElementById("password-edit").value;
    var email = document.getElementById("email-edit").value;
    var sex = document.getElementById("sex-edit").value;
    var position = document.getElementById("position-edit").value;
    var telephoneNum = document.getElementById("telephoneNum-edit").value;
    alert(JSON.stringify({"id":id, "username":username, "password":password, "email":email, "sex":sex, "position":position, "telephoneNum":telephoneNum}));
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
  };
  function click_edit(id){
    // var data_id = btn.parentNode.parentNode.firstChild.nextSibling.textContent;
    // console.log("data sex:"+data_id);
    var data = $("#userid").val();
    console.log("data:"+data);
    var data1 = document.getElementById("userid").value;
    console.log("data1:"+data1);
    // var id=$(obj).attr("id");
    console.log("id:"+id);
    var name = $(this).closest("tr").find("td").eq(0).text();
    console.log("name:"+name);
    var username = document.getElementById("username-td").innerHTML;
    console.log("username:"+username);
    // var rows = $("#editTable").bootstrapTable("getSelections");
    // if(rows.length==1){
    //   console.log(rows[0].id);
    // }
    
    // var username = document.getElementById("editTable").rows[id].cells[0].innerText;
    // var password = document.getElementById("editTable").rows[id].cells[1].innerText;
    // var email = document.getElementById("editTable").rows[id].cells[2].innerText;
    // var sex = document.getElementById("editTable").rows[id].cells[3].innerText;
    // var position = document.getElementById("editTable").rows[id].cells[4].innerText;
    // var telephoneNum = document.getElementById("editTable").rows[id].cells[5].innerText;
    var username = "testx";
    $('#modalEdit').on('click', function(){
      $('#modalTest').modal('show');
    });

    $('#modalTest').on('show.bs.modal', function(event){
      var modal=$(this);
      // p标签数据
      modal.find('.modal-body #id').text("trans data");
      // input 数据
      modal.find('.modal-body input#username').val("haha");
    });
    var tableRef = document.getElementById("editTable");
    console.log("uu id:"+tableRef.innerHTML.id);
    var elemRef = tableRef.rows[4].cells[1];
    console.log("datas:"+elemRef.innerText);
    // var tableElems = $('table');
    // for(var index=0, len=tableElems.length;index<len;index++){
    //   var tableElem = $(tableElems[index]);
    //   console.log(tableElem);
    // }
    
    // $("#username").val(username);
    // $("#password").val(password);
    // $("#email").val(email);
    // $("#sex").val(sex);
    // $("#position").val(position);
    // $("#telephoneNum").val(telephoneNum);
    
  };

  // $(function(){
  //   // $('#modalEdit').on('click', function(){
  //   //   $('#modalTest').modal('show');
  //   // });
  //   $('#modalTest').on('show.bs.modal', function(event){
  //     var modal=$(this);
  //     // p标签数据
  //     // modal.find('.modal-body #id').text("trans data");
  //     // input 数据
  //     modal.find('.modal-body input#username').val("haha");
  //   });
  //   // $('#modalEdit').on('click', function(){
  //   //   $('#modalTest').modal('show');
  //   // });
  // });

  function table_click(){
    var rows = document.getElementById("editTable").rows.length;
    console.log("rows:"+rows);
    // var uid = "";
    // var username = "";
    // var password = "";
    // var email = "";
    // var sex = "";
    // var position = "";
    // var telephoneNum = "";
    $("#editTable tr").click(function(){
      var td=$(this).find("td");
      uid = td.eq(1).html();
      console.log("uid:"+uid);
      username = td.eq(2).html();
      password = td.eq(3).html();
      email = td.eq(4).html();
      sex = td.eq(5).html();
      position = td.eq(6).html();
      telephoneNum = td.eq(7).html();
    });
    console.log("uid new:"+uid);
    $('#modalTest').on('show.bs.modal', function(event){
      var modal=$(this);
      // p标签数据
      // modal.find('.modal-body #id').text("trans data");
      // input 数据
      modal.find('.modal-body input#uid').val(uid);
      modal.find('.modal-body input#username').val(username);
      modal.find('.modal-body input#password').val("password");
      modal.find('.modal-body input#email').val("email");
      modal.find('.modal-body input#sex').val("sex");
      modal.find('.modal-body input#position').val("position");
      modal.find('.modal-body input#telephoneNum').val("telephoneNum");
      
    });
    $('#modalTest').modal('show');
      
    
    // var td = event.srcElement;
    // console.log("row id:"+td.parentElement.rowIndes);
  };
  function table_click_test(){
    var rows = document.getElementById("editTable").rows.length;
    console.log("rows:"+rows);
    // var uid = "";
    // var username = "";
    // var password = "";
    // var email = "";
    // var sex = "";
    // var position = "";
    // var telephoneNum = "";
    $("#editTable tr").click(function(){
      var td=$(this).find("td");
      uid = td.eq(1).html();
      console.log("uid:"+uid);
      username = td.eq(2).html();
      sex = td.eq(3).html();
      position = td.eq(4).html();
      telephoneNum = td.eq(5).html();

      console.log("uid new:"+uid);
      $('#modalTest').on('show.bs.modal', function(event){
        var modal=$(this);
        // p标签数据
        // modal.find('.modal-body #id').text("trans data");
        // input 数据
        modal.find('.modal-body input#uid').val(uid);
        modal.find('.modal-body input#username-edit').val(username);
        modal.find('.modal-body input#password-edit').val("");
        modal.find('.modal-body input#email-edit').val("");
        modal.find('.modal-body input#sex-edit').val(sex);
        modal.find('.modal-body input#position-edit').val(position);
        modal.find('.modal-body input#telephoneNum-edit').val(telephoneNum);
        
      });
      $('#modalTest').modal('show');
    });
    
      
    
    // var td = event.srcElement;
    // console.log("row id:"+td.parentElement.rowIndes);
  };
  function click_query_page(){
    // var pageLi = document.getElementById("page-ul").getElementsByTagName("li");
    console.log("click select");
    var pageSize = $("#maxsize option:selected");
    var opts = document.getElementById("maxsize");
    console.log("option value:"+opts.options[0].value);
    
    console.log("option value:"+pageSize.val());
    window.location.href="http://localhost:8090/api/page/datasshow?pageNum=1&pageSize="+pageSize.val();
    // opts.options[i].selected = "selected";
    //   $.ajax({
  //     type:'get', 
  //     url:'http://localhost:8090/api/page/datasshow?pageNum=1&pageSize='+pageSize.val(),
  //     success: function(){
  //       console.log("success");
  //     }
  //   }
  // );

  }
