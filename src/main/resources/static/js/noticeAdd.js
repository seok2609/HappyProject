let results = [false,false];

$("#noticeAddBtn").click(function(){

    if(results.includes(false)){
        alert("입력하지 않은 부분이 있습니다");
    }else{
        $("#writeForm").submit();
    }
});

$("#inputWriter").blur(function(){
    let result = nullCheck($("#inputWriter").val());
    results[0] = result;
    if(result){
        $("#writerHelp").html("통과");

    }else{
        $("#writerHelp").html("작성자를 입력해주세요");
    }
});

$("#inputTitle").blur(function(){
    let result = nullCheck($("#inputTitle").val());
    results[1] = result;
    if(result){
        $("#titleHelp").html("통과");

    }else{
        $("#titleHelp").html("제목을 입력해주세요");
    }
});

// $("#inputContents").blur(function(){
//     let result = nullCheck($("#inputContents").val());
//     results[0] = result;
//     if(result){
//         $("#contentsHelp").html("통과");

//     }else{
//         $("#contentsHelp").html("내용을 입력해주세요");
//     }
// });