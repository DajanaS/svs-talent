import {Component} from '@angular/core';
import {MemberService} from './member.service';
import {BookService} from './book.service';
import {Member} from './member';
import {Book} from './book';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Library';
  public members: Member[];
  public books: Book[];
  public memberCounts: string[];
  public bookCounts: string[];

  constructor(private memberService: MemberService, private bookService: BookService) {
  }

  registerMember(name: string) {
    name = name.trim();
    if (!name) {
      return;
    }
    this.memberService.addMember(name).subscribe(/* error handling */);
  }

  registerBook(isbn: string, title: string) {
    isbn = isbn.trim();
    title = title.trim();
    if (!isbn || !title) {
      return;
    }
    this.bookService.addBook(isbn, title).subscribe(/* error handling */);
  }

  getMembers() {
    this.memberService.getMembers().subscribe(members => this.members = members);
    this.memberService.getMemberCounts().subscribe(memberCounts => this.memberCounts = memberCounts);
  }

  getBooks() {
    this.bookService.getBooks().subscribe(books => this.books = books);
    this.bookService.getBookCounts().subscribe(bookCounts => this.bookCounts = bookCounts);
  }

  getBoth() {
    this.getMembers();
    this.getBooks();
  }

  landBook(memberId, bookId) {
    if (!memberId || !bookId) {
      return;
    }
    this.memberService.landBook(memberId, bookId).subscribe();
  }
}
