const articles_btn = document.getElementsByClassName('voteBtn');
for (let i = 0; i < articles_btn.length; i++) {
    let article_id = articles_btn[i].parentElement.getAttribute('data-article');
    //
    articles_btn[i].addEventListener('click', e => {
        voteArticle(article_id);
    });
}

function voteArticle(idArticle) {
    axios.post(`/articles?action=vote&article=${idArticle}`)
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        });
    //
}
// 