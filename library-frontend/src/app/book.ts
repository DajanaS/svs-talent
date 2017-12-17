export class Book {
  public isbn: string;
  public title: string;
  public id: number;

  constructor(isbn, title) {
    this.isbn = isbn;
    this.title = title;
  }
}
