const __articles = document.getElementsByClassName('articleCard');
//
let __last_selected_article = -1;
//
for (let i = 0; i < __articles.length; i++) {
    __articles[i].addEventListener('click', async e => {
        await displayEvent(e, __articles[i].dataset.article, i);
    });
}
//
const displayEvent = async (e, article_id, i) => {
    if (e.target.dataset.display == undefined) {
        //side bar
        const sideBar = document.getElementById('sideBar');
        const dispArticle = document.getElementById('state_1');
        const manipulateArticle = document.getElementById('state_2');
        //side bar management
        if (__last_selected_article != article_id) {
            //update content
            let response = await axios.post(`/articles?action=get&article=${article_id}`);
            if (response.data != null || response.data != 'null') {
                console.log(response.data);
                if (response.data.status == 1) {
                    let articleData = response.data.article;
                    //
                    document.getElementById('af_name').innerText = articleData.articleName;
                    document.getElementById('af_price').innerText = articleData.articlePrice;
                    document.getElementById('af_nbProduits').innerText = articleData.articleNb;
                    document.getElementById('af_desc').innerText = articleData.articleDesc;
                    document.getElementById('af_img').setAttribute('src', articleData.articleImg);
                    // 
                    let voteBtn_X = document.getElementById('af_voteBtn_X');
                    let voteBtn_Y = document.getElementById('af_voteBtn_Y');
                    // 
                    if (response.data.role == "client") {
                        if (response.data.vote == 1) {
                            if (voteBtn_X.classList.contains('hidden'))
                                voteBtn_X.classList.remove('hidden');
                            if (!voteBtn_Y.classList.contains('hidden'))
                                voteBtn_Y.classList.add('hidden');
                        } else {
                            if (!voteBtn_X.classList.contains('hidden'))
                                voteBtn_X.classList.add('hidden');
                            if (voteBtn_Y.classList.contains('hidden'))
                                voteBtn_Y.classList.remove('hidden');
                        }
                    } else {
                        if (!voteBtn_Y.classList.contains('hidden'))
                            voteBtn_Y.classList.add('hidden');
                        if (!voteBtn_X.classList.contains('hidden'))
                            voteBtn_X.classList.add('hidden');
                    }
                    //
                    // 
                    if (dispArticle.classList.contains('hidden'))
                        dispArticle.classList.remove('hidden');
                    if (manipulateArticle != null) {
                        if (!manipulateArticle.classList.contains('hidden'))
                            manipulateArticle.classList.add('hidden');
                    }
                    //show if not shown
                    if (sideBar.classList.contains('hidden'))
                        sideBar.classList.remove('hidden');
                    // 
                    __last_selected_article = article_id;
                } else if (response.data.status == 0) {
                    console.log("Server error");
                } else {
                    console.log("you don't have the right to perform this action");
                }
            } else
                console.log('Fatal error server side');
        } else {
            //hide side bar
            if (!sideBar.classList.contains('hidden'))
                sideBar.classList.add('hidden');
            // 
            __last_selected_article = -1;
        }
        if (typeof articlePos != undefined)
            articlePos = __last_selected_article;
    }
}