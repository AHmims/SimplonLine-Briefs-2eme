const articles_editBtn = document.getElementsByClassName('editBtn');
const articles_deleteBtn = document.getElementsByClassName('deleteBtn');
//
for (let i = 0; i < articles_editBtn.length; i++) {
    let article_id = articles_editBtn[i].dataset.article;
    //EDIT
    articles_editBtn[i].addEventListener('click', async e => {
        //validate inputs before
        /*let response = await axios.post(`/articles?action=edit&article=${article_id}&`);
        console.log(response);*/
        let formData = new FormData();
        formData.append("action", "hmmm");
        formData.append("dafuk", "meh");
        axios.post('/formData-test',
                formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }
            ).then(function () {
                console.log('SUCCESS!!');
            })
            .catch(function () {
                console.log('FAILURE!!');
            });
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
//