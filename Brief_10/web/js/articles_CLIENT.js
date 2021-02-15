const articles_btn = document.getElementsByClassName('voteBtn');
// 
for (let i = 0; i < articles_btn.length; i++) {
    let article_id = articles_btn[i].dataset.article;
    //
    articles_btn[i].addEventListener('click', async e => {
        let response = await axios.post(`/articles?action=vote&article=${article_id}`);
        console.log(response);
        //
        if (response.data != null || response.data != 'null') {
            if (response.data.status == 1) {
                //DUMP BUT GOOD FOR FUTURE CHANGES
                let state = articles_btn[i].dataset.toggle;
                if (state == 'true') {
                    // articles_btn[i].innerText = "VOTE";
                    articles_btn[i].classList.add("bg-coolGray-100");
                    articles_btn[i].classList.remove("bg-red-50");
                    articles_btn[i].children[0].classList.add("text-coolGray-300");
                    articles_btn[i].children[0].classList.remove("text-red-500");
                } else {
                    // articles_btn[i].innerText = "unVOTE";
                    articles_btn[i].classList.remove("bg-coolGray-100");
                    articles_btn[i].classList.add("bg-red-50");
                    articles_btn[i].children[0].classList.remove("text-coolGray-300");
                    articles_btn[i].children[0].classList.add("text-red-500");
                }
                articles_btn[i].dataset.toggle = state == 'true' ? false : true;
            } else if (response.data.status == 0) {
                logServerError();
            } else {
                logWarningActive("Vous n'avez pas le droit d'effectuer cette action");
            }
        } else logServerError();
    });
}