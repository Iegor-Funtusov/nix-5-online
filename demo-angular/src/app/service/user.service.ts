import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { api } from '../consts/api';
import { FilterData } from '../model/filter-data';
import { UserData } from '../model/user-data';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = api + '/users/';

  constructor(private http: HttpClient) { }

  findAll(data: FilterData): Observable<any> {
    const params = new HttpParams()
      .set('page', data.currentPage)
      .set('size', data.pageSize)
      .set('sort', data.sort)
      .set('order', data.order);
    return this.http.get(this.url, { params: params })
  }

  findById(id: number): Observable<any> {
    return this.http.get(this.url + id);
  }

  create(data: UserData): Observable<any> {
    return this.http.post(this.url, data);
  }

  update(data: UserData): Observable<any> {
    return this.http.put(this.url + data.id, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(this.url + id);
  }
}
