export class Book {
  public id: string;
  public isbn: string;
  public title: string;

  constructor(id, isbn, title) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
  }
}
