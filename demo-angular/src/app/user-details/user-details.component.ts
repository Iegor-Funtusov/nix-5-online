import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { UserService } from '../service/user.service';
import { UserData } from '../model/user-data';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  userDetails: Observable<UserData>;
  dateFormat = 'dd.MM.yy HH:mm:ss';

  constructor(private route: ActivatedRoute, private usersService: UserService) {
    const routeParams = this.route.snapshot.paramMap;
    const id = Number(routeParams.get('id'));
    this.userDetails = this.usersService.findById(id);
  }

  ngOnInit(): void { }
}
