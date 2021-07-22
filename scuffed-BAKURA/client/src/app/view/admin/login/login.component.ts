import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {AuthenticationService} from '../../../services/authentication/authentication.service';
import {LoginData} from '../../../models/login-data.model';
import {AuthResponse} from '../../../models/auth-response.model';
import {LocalstorageService} from '../../../services/localstorage/localstorage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: []
})

export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    email: '',
    password: ''
  });

  constructor(private localStorageService: LocalstorageService, private authenticationService: AuthenticationService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    let formData: LoginData = new LoginData().deserialize(this.loginForm.value);
    this.authenticationService.login(formData).subscribe((data: AuthResponse) => {
      this.localStorageService.set('token', data.token || '');
      alert('good');
    }, error => {
      console.error(error.error);
      alert('bad');
    });
  }

}
