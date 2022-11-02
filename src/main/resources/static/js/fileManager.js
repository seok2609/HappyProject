
let count = 0;

$("#fileAdd").click(function(){

    if(count < 5){
        let plus = '<div class="mb-3">';
        plus = plus+'<label for="contents" class="form-label">파일</label>';
        plus = plus+'<input type="file" name="files">';
        plus = plus+'<button type="button" class="del">X</button>'
        plus = plus+'</div>';
        $("#fileAddResult").append(plus);
        count++;
    }else {
        alert("최대 5개만 가능합니다.")
    }


    $("#fileAddResult").on("click", ".del", function(){
        $(this).parent().remove();
        count--;
    });
    

});