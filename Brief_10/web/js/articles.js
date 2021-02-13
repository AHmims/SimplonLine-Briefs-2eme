const __articles = document.getElementsByClassName('articleCard');
const __articles_btn = document.getElementsByClassName('voteBtn');
// 
for (let i = 0; i < __articles.length; i++) {
    __articles[i].addEventListener('click', e => {
        console.log(e.target);
    });
}