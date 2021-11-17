const books = document.getElementsByClassName("delete");
Array.from(books).forEach((book) => {
		book.onclick = (e) => {
			if(!confirm("you want to delete?")) {
				e.preventDefault();
			}
		};
});

