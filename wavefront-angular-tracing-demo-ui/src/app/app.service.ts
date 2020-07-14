import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AppService {

  constructor(private httpClient: HttpClient) {
  }

  sendRequest(): Observable<string> {
    return this.httpClient.get('http://localhost:8080/hello', {responseType: 'text' as 'text'});
  }
}
