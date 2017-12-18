import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Book} from './book';
import {catchError} from 'rxjs/operators';
import {of} from 'rxjs/observable/of';

@Injectable()
export class BookService {

  constructor(private http: HttpClient) {
  }

  public addBook(bookIsbn: string, bookTitle: string) {
    return this.http.post('http://localhost:8080/books', {
      isbn: bookIsbn,
      title: bookTitle
    }).map((res: Response) => res.json());
  }

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>('http://localhost:8080/books').pipe(
      catchError(this.handleError('getBooks', []))
    );
  }

  public getBookMembers(id): Observable<Book[]> {
    return this.http.get<Book[]>('http://localhost:8080/lending/book/' + id).pipe(
      catchError(this.handleError('getBookMembers', []))
    );
  }

  public getBookCounts(): Observable<string[]> {
    return this.http.get<string[]>('http://localhost:8080/lending/members').pipe(
      catchError(this.handleError('getBookCounts', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
