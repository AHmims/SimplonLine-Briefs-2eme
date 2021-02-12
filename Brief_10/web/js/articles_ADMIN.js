const articles_editBtn = document.getElementsByClassName('editBtn');
const articles_deleteBtn = document.getElementsByClassName('deleteBtn');
//
for (let i = 0; i < articles_editBtn.length; i++) {
    let article_id = articles_editBtn[i].parentElement.dataset.article;
    //EDIT
    articles_editBtn[i].addEventListener('click', async e => {
        // let response = await axios.post(`/articles?action=edit&article=${article_id}&`);
        // console.log(response);
    });
    //DELETE
    articles_deleteBtn[i].addEventListener('click', async e => {
        //maybe a confirmation prompt here !
        let response = await axios.post(`/articles?action=delete&article=${article_id}`);
        console.log(response);
        if (response.data.status == 1) {
            articles_deleteBtn[i].remove();
        } else if (response.data.status == 0) {
            console.log("Server error");
        } else {
            console.log("you don't have the right to perform this action");
        }
    });
}
//