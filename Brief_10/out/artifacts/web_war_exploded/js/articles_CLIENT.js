const articles_btn = document.getElementsByClassName('voteBtn');
for (let i = 0; i < articles_btn.length; i++) {
    let article_id = articles_btn[i].parentElement.dataset.article;
    //
    articles_btn[i].addEventListener('click', async e => {
        let response = await axios.post(`/articles?action=vote&article=${article_id}`);
        console.log(response);
        //
        if (response.data.status == 1) {
            //DUMP BUT GOOD FOR FUTURE CHANGES
            let state = articles_btn[i].dataset.toggle;
            if (state == 'true') {
                articles_btn[i].innerText = "VOTE";
            } else {
                articles_btn[i].innerText = "unVOTE";
            }
            articles_btn[i].dataset.toggle = state == 'true' ? false : true;
        } else if (response.data.status == 0) {
            console.log("Server error");
        } else {
            console.log("you don't have the right to perform this action");
        }
    });
}