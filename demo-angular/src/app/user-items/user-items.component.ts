import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { UserService } from '../service/user.service';
import { PageData } from '../model/page-data';
import { FilterData } from '../model/filter-data';

@Component({
  selector: 'app-user-items',
  templateUrl: './user-items.component.html',
  styleUrls: ['./user-items.component.scss']
})
export class UserItemsComponent implements OnInit {

  pageData: Observable<PageData>;
  filterData: FilterData;
  columns: string[] = [ '#', 'id', 'created', 'name', 'email', 'details', 'delete' ];
  dateFormat: string = 'dd.mm.yy hh:mm:ss';

  constructor(private router: Router, private userService: UserService) {
    this.filterData = {
      currentPage: 1,
      pageSize: 10,
      order: 'desc',
      sort: 'id'
    }
    this.pageData = this.userService.findAll(this.filterData);
  }

  ngOnInit(): void { }

  delete(id: number): void {
    this.userService.delete(id).subscribe(() => {
      this.pageData = this.userService.findAll(this.filterData);
    });
  }

  details(id: number): void {
    this.router.navigateByUrl('/users/' + id);
  }

  create(): void {
    this.router.navigateByUrl('user-new');
  }
}
