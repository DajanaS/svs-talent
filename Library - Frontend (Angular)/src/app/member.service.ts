import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {HttpClient} from '@angular/common/http';
import {Member} from './member';
import {catchError} from 'rxjs/operators';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';

@Injectable()
export class MemberService {

  constructor(private http: HttpClient) {
  }

  public addMember(memberName: string) {
    return this.http.post('http://localhost:8080/members', {name: memberName}).map((res: Response) => res.json());
  }

  public getMembers(): Observable<Member[]> {
    return this.http.get<Member[]>('http://localhost:8080/members').pipe(
      catchError(this.handleError('getMembers', []))
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
