const articles_editBtn = document.getElementsByClassName('editBtn');
const articles_deleteBtn = document.getElementsByClassName('deleteBtn');
let articlePos = -1;
//
for (let i = 0; i < articles_editBtn.length; i++) {
    let article_id = articles_editBtn[i].dataset.article;
    //EDIT
    articles_editBtn[i].addEventListener('click', async e => {
        await editEvent(article_id, i);
    });
    //DELETE
    articles_deleteBtn[i].addEventListener('click', async e => {
        await deleteEvent(article_id, i);
    });
}
// 
async function editEvent(article_id, i) {
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
}

async function deleteEvent(article_id, i) {
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
}
// 
//
//event for form submit
document.getElementById('_article_validate').addEventListener('click', async e => {
    if (articlePos == -2) {
        let formData = new FormData();
        formData.append("action", "add");
        let response = await articleFormDataRequest(formData);
        //
        if (response.data != null || response.data != 'null') {
            if (response.data.status == 1) {
                document.getElementById('articlesContainer').appendChild(createArticleCard(response.data.article));
            } else if (response.data.status == 0) {
                console.log("Server error, not saved");
            } else if (response.data.status == -2) {
                console.log("Form not valid");
            } else {
                console.log("you don't have the right to perform this action");
            }
        } else
            console.log('Fatal error server side');
    } else {
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
    }
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
//
//
document.getElementById('addBtn').addEventListener('click', e => {
    //show form
    articlePos = -2;
    document.getElementById('_article_name').value = "";
    document.getElementById('_article_price').value = "";
    document.getElementById('_article_nb').value = "";
    document.getElementById('_article_desc').value = "";
});
//
//
const createArticleCard = (articleData) => {
    let container = document.createElement('div');
    container.setAttribute('class', 'articleCard');
    //
    //
    let img = document.createElement('img');
    img.setAttribute('class', 'articleCard_image');
    img.setAttribute('src', articleData.articleImg);
    img.setAttribute('width', '100px');
    //
    let name = document.createElement('span');
    name.setAttribute('class', 'articleCard_name');
    name.innerText = articleData.articleName;
    //
    let price = document.createElement('span');
    price.setAttribute('class', 'articleCard_price');
    price.innerText = articleData.articlePrice;
    //
    let btnsCont = document.createElement('div');
    let btnDelete = document.createElement('button');
    btnDelete.setAttribute('class', 'deleteBtn');
    btnDelete.innerText = "Delete";
    btnDelete.addEventListener('click', async e => {
        await deleteEvent(articleData.articleId, document.getElementsByClassName('articleCard').length);
    });
    let btnEdit = document.createElement('button');
    btnEdit.setAttribute('class', 'editBtn');
    btnEdit.setAttribute('data-article', articleData.articleId);
    btnEdit.innerText = "Edit";
    btnDelete.addEventListener('click', async e => {
        await editEvent(articleData.articleId, document.getElementsByClassName('articleCard').length);
    });
    //
    btnsCont.appendChild(btnEdit);
    btnsCont.appendChild(btnDelete);
    //
    container.appendChild(img);
    container.appendChild(name);
    container.appendChild(price);
    container.appendChild(btnsCont);
    //
    return container;
}