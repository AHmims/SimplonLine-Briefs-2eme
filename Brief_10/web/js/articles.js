const __articles = document.getElementsByClassName('articleCard');
//
let __last_selected_article = -1;
//
for (let i = 0; i < __articles.length; i++) {
    __articles[i].addEventListener('click', e => {
        if (e.target.dataset.display == undefined) {
            //side bar
            const sideBar = document.getElementById('sideBar');
            const dispArticle = document.getElementById('state_1');
            const manipulateArticle = document.getElementById('state_2');
            //side bar management
            if (__last_selected_article != __articles[i].dataset.article) {
                //update content
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
                __last_selected_article = __articles[i].dataset.article;
            } else {
                //hide side bar
                if (!sideBar.classList.contains('hidden'))
                    sideBar.classList.add('hidden');
                // 
                __last_selected_article = -1;
            }
        }
    });
}