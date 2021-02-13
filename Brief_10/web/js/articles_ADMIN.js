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
        formData.append("article", -999);
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
    } else if (articlePos != -1) {
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
    } else console.log("action can't be performed");
});
//
const articleFormDataRequest = async formData => {
    formData.append("articleName", document.getElementById('_article_name').value);
    formData.append("articlePrice", document.getElementById('_article_price').value);
    formData.append("articleNb", document.getElementById('_article_nb').value);
    formData.append("articleDesc", document.getElementById('_article_desc').value);
    formData.append("articleImg", document.getElementById('_article_img').files[0]);
    console.log(formData);
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
    const pos = document.getElementsByClassName('articleCard').length;
    // 
    let container = document.createElement('div');
    container.setAttribute('class', 'articleCard bg-white h-420 rounded-50 border-3 border-coolGray-100 flex flex-col p-7 justify-between');
    container.setAttribute('data-article', articleData.articleId);
    //
    //TOP
    let topCont = document.createElement('div');
    topCont.setAttribute('class', 'relative w-full h-64');
    //
    let img = document.createElement('img');
    img.setAttribute('class', 'articleCard_image rounded-34 select-none object-cover w-full h-full');
    img.setAttribute('src', articleData.articleImg);
    topCont.appendChild(img);
    //
    let btnsCont = document.createElement('div');
    btnsCont.setAttribute('class', 'flex flex-col absolute bottom-0 right-0 space-y-2.5');
    let btnDelete = document.createElement('button');
    btnDelete.setAttribute('class', 'deleteBtn p-3 bg-rose-100 rounded-20');
    btnDelete.setAttribute('data-display', 'no');
    btnDelete.innerHTML += `<svg data-display="no" width="30" height="30" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path data-display="no" fill-rule="evenodd" clip-rule="evenodd" d="M13.5 3C13.2215 3.00015 12.9486 3.07782 12.7117 3.22433C12.4749 3.37083 12.2835 3.58038 12.159 3.8295L11.073 6H6C5.60218 6 5.22064 6.15804 4.93934 6.43934C4.65804 6.72064 4.5 7.10218 4.5 7.5C4.5 7.89782 4.65804 8.27936 4.93934 8.56066C5.22064 8.84196 5.60218 9 6 9V24C6 24.7956 6.31607 25.5587 6.87868 26.1213C7.44129 26.6839 8.20435 27 9 27H21C21.7956 27 22.5587 26.6839 23.1213 26.1213C23.6839 25.5587 24 24.7956 24 24V9C24.3978 9 24.7794 8.84196 25.0607 8.56066C25.342 8.27936 25.5 7.89782 25.5 7.5C25.5 7.10218 25.342 6.72064 25.0607 6.43934C24.7794 6.15804 24.3978 6 24 6H18.927L17.841 3.8295C17.7165 3.58038 17.5251 3.37083 17.2883 3.22433C17.0514 3.07782 16.7785 3.00015 16.5 3H13.5ZM10.5 12C10.5 11.6022 10.658 11.2206 10.9393 10.9393C11.2206 10.658 11.6022 10.5 12 10.5C12.3978 10.5 12.7794 10.658 13.0607 10.9393C13.342 11.2206 13.5 11.6022 13.5 12V21C13.5 21.3978 13.342 21.7794 13.0607 22.0607C12.7794 22.342 12.3978 22.5 12 22.5C11.6022 22.5 11.2206 22.342 10.9393 22.0607C10.658 21.7794 10.5 21.3978 10.5 21V12ZM18 10.5C17.6022 10.5 17.2206 10.658 16.9393 10.9393C16.658 11.2206 16.5 11.6022 16.5 12V21C16.5 21.3978 16.658 21.7794 16.9393 22.0607C17.2206 22.342 17.6022 22.5 18 22.5C18.3978 22.5 18.7794 22.342 19.0607 22.0607C19.342 21.7794 19.5 21.3978 19.5 21V12C19.5 11.6022 19.342 11.2206 19.0607 10.9393C18.7794 10.658 18.3978 10.5 18 10.5Z" fill="#E11D48" /></svg>`;
    btnDelete.addEventListener('click', async e => {
        await deleteEvent(articleData.articleId, pos);
    });
    let btnEdit = document.createElement('button');
    btnEdit.setAttribute('class', 'editBtn p-3 bg-coolGray-100 rounded-20');
    btnEdit.setAttribute('data-article', articleData.articleId);
    btnEdit.setAttribute('data-display', 'no');
    btnEdit.innerHTML += `<svg width="30" height="30" data-display="no" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path data-display="no" d="M26.121 3.87885C25.5584 3.31643 24.7955 3.00049 24 3.00049C23.2045 3.00049 22.4416 3.31643 21.879 3.87885L10.5 15.2578V19.4998H14.742L26.121 8.12085C26.6834 7.55826 26.9994 6.79534 26.9994 5.99985C26.9994 5.20436 26.6834 4.44143 26.121 3.87885Z" fill="#4B5563" />
    <path data-display="no" fill-rule="evenodd" clip-rule="evenodd" d="M3 9C3 8.20435 3.31607 7.44129 3.87868 6.87868C4.44129 6.31607 5.20435 6 6 6H12C12.3978 6 12.7794 6.15804 13.0607 6.43934C13.342 6.72064 13.5 7.10218 13.5 7.5C13.5 7.89782 13.342 8.27936 13.0607 8.56066C12.7794 8.84196 12.3978 9 12 9H6V24H21V18C21 17.6022 21.158 17.2206 21.4393 16.9393C21.7206 16.658 22.1022 16.5 22.5 16.5C22.8978 16.5 23.2794 16.658 23.5607 16.9393C23.842 17.2206 24 17.6022 24 18V24C24 24.7956 23.6839 25.5587 23.1213 26.1213C22.5587 26.6839 21.7956 27 21 27H6C5.20435 27 4.44129 26.6839 3.87868 26.1213C3.31607 25.5587 3 24.7956 3 24V9Z" fill="#4B5563" /></svg>`;
    btnEdit.addEventListener('click', async e => {
        await editEvent(articleData.articleId, pos);
    });
    //
    btnsCont.appendChild(btnEdit);
    btnsCont.appendChild(btnDelete);
    topCont.appendChild(btnsCont);
    // 
    container.appendChild(topCont);
    //
    // 
    let botCont = document.createElement('div');
    botCont.setAttribute('class', 'flex flex-col');
    //
    let priceCont = document.createElement('div');
    priceCont.setAttribute('class', 'text-coolGray-500 font-SourceSansPro flex flex-row items-baseline');
    let price = document.createElement('span');
    price.setAttribute('class', 'articleCard_price font-semibold text-3xl');
    price.innerText = articleData.articlePrice;
    let priceTag = document.createElement('span');
    priceTag.setAttribute('class', 'font-normal text-xl');
    priceCont.appendChild(price);
    priceCont.appendChild(priceTag);
    botCont.appendChild(priceCont);
    //
    let name = document.createElement('span');
    name.setAttribute('class', 'articleCard_name mt-0.5 font-Kollektif font-bold text-2xl text-warmGray-700 truncate whitespace-pre');
    name.innerText = articleData.articleName;
    botCont.appendChild(name);
    container.appendChild(botCont);
    //
    //
    //
    return container;
}