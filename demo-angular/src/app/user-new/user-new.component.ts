import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: ['./user-new.component.scss']
})
export class UserNewComponent implements OnInit {

  userForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
  });

  constructor(private router: Router, private usersService: UserService) { }

  ngOnInit(): void { }

  create() {
    this.usersService.create(this.userForm.value).subscribe(() => {
      this.router.navigateByUrl('/users');
    })
  }
}
