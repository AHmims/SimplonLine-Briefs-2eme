const __articles = document.getElementsByClassName('articleCard');
//
let __last_selected_article = -1;
//
for (let i = 0; i < __articles.length; i++) {
    __articles[i].addEventListener('click', e => {
        if (e.target.dataset.display == undefined) {
            //side bar
            const sideBar = document.getElementById('sideBar');
            //side bar management
            if (__last_selected_article != __articles[i].dataset.article) {
                //update content

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