function voteArticle() {
    //
    axios({
            method: 'post',
            url: '/articles',
            headers: {
                //'Content-Type': 'application/json'
                contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
                dataType: "json"
            },
            data: JSON.stringify({
                action: 'vote',
                articleId: '12'
            })
        })
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });

}
// 