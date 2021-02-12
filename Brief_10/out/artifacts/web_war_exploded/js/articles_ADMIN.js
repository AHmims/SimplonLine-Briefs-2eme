const articles_editBtn = document.getElementsByClassName('editBtn');
const articles_deleteBtn = document.getElementsByClassName('deleteBtn');
let articlePos = -1;
//
for (let i = 0; i < articles_editBtn.length; i++) {
    let article_id = articles_editBtn[i].dataset.article;
    //EDIT
    articles_editBtn[i].addEventListener('click', async e => {
        //Display form
        articlePos = i;
        //get article data
        let response = await axios.post(`/articles?action=get&article=${article_id}`);
        if (response.data != null || response.data != 'null') {
            if (response.data.status == 1) {
                let articleData = response.data.article;
                //
                document.getElementById('_article_name').value = articleData.articleName;
                document.getElementById('_article_price').value = articleData.articlePrice;
                document.getElementById('_article_nb').value = articleData.articleNb;
                document.getElementById('_article_desc').value = articleData.articleDesc;
            } else if (response.data.status == 0) {
                console.log("Server error");
            } else {
                console.log("you don't have the right to perform this action");
            }
        } else
            console.log('Fatal error server side');
    });
    //DELETE
    articles_deleteBtn[i].addEventListener('click', async e => {
        //maybe a confirmation prompt here !
        let response = await axios.post(`/articles?action=delete&article=${article_id}`);
        console.log(response);
        if (response.data != null || response.data != 'null') {
            if (response.data.status == 1) {
                document.getElementsByClassName('articleCard')[i].remove();
            } else if (response.data.status == 0) {
                console.log("Server error");
            } else {
                console.log("you don't have the right to perform this action");
            }
        } else
            console.log('Fatal error server side');
    });
}
//event for form submit
document.getElementById('_article_validate').addEventListener('click', async e => {
    idArticle = articles_editBtn[articlePos].dataset.article;
    if (idArticle != -1) {
        //validate inputs before
        /*let response = await axios.post(`/articles?action=edit&article=${article_id}&`);
        console.log(response);*/
        let formData = new FormData();
        formData.append("action", "edit");
        formData.append("article", idArticle);
        let response = await articleFormDataRequest(formData);
        //
        if (response.data != null || response.data != 'null') {
            if (response.data.status == 1) {
                document.getElementsByClassName('articleCard_image')[articlePos].setAttribute('src', `/images/${document.getElementById('_article_img').files[0].name}`);
                document.getElementsByClassName('articleCard_name')[articlePos].innerText = document.getElementById('_article_name').value;
                document.getElementsByClassName('articleCard_price')[articlePos].innerText = document.getElementById('_article_price').value;
            } else if (response.data.status == 0) {
                console.log("Server error, edits not made");
            } else if (response.data.status == -2) {
                console.log("Form not valid");
            } else {
                console.log("you don't have the right to perform this action");
            }
        } else
            console.log('Fatal error server side');

    } else console.log('nn');
});
//
const articleFormDataRequest = async formData => {
    formData.append("articleName", document.getElementById('_article_name').value);
    formData.append("articlePrice", document.getElementById('_article_price').value);
    formData.append("articleNb", document.getElementById('_article_nb').value);
    formData.append("articleDesc", document.getElementById('_article_desc').value);
    formData.append("articleImg", document.getElementById('_article_img').files[0]);
    //
    return await axios.post('/articles', formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    });
}