import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { environment } from '../../environment';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ReactiveFormsModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  emiForm: FormGroup;
  emiValue: Number = 0;
  emiError: String = '';
  apiEndPoint: string = environment.apiEndpoint;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.emiForm = this.fb.group({
      loanValue: [0, [Validators.required, Validators.min(1)]],
      yearlyInterestRate: [0, [Validators.required, Validators.min(0), Validators.max(100)]],
      loanTerm: [0, [Validators.required, Validators.min(0), Validators.max(30)]],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onSubmit() {
    if (this.emiForm.invalid) {
      return;
    }

    this.http.post(this.apiEndPoint, this.emiForm.value)
      .subscribe({
        next: (response) => {
          this.emiError = ''
          this.emiValue = response as Number
        },
        error: (error) => {
          this.emiError = error
        },
        complete: () => {
          console.log('Data fetching completed');
        }
      });
  }
}
