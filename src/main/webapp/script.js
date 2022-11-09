function myFunction(){
document.querySelector('.dropdown-content').classList.toggle("hidden");
}
window.onclick = function(event) {
    if (!event.target.matches('.check-element')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (!openDropdown.classList.contains('hidden')) {
                openDropdown.classList.toggle('hidden');
            }
        }
    }
}

const handleClick = (e) =>{

    e.preventDefault();

}

