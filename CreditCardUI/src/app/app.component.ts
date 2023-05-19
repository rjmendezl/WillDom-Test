import { Component, OnInit } from '@angular/core';
import { CardService } from './services/card.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import swal from 'sweetalert';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  
  cardForm! : FormGroup;

  constructor(
    public fb: FormBuilder,
    public cardService: CardService
  ){

  }

  
  ngOnInit(): void {
    this.cardForm = this.fb.group({
        owner : ['', Validators.required],
        number : ['', Validators.required],
        cvv : ['', Validators.required],
        month : ['', Validators.required],
        year : ['', Validators.required]
    })
  }

  saveCard(): void {
    this.cardService.saveCard(this.cardForm.value).subscribe( 
        result => { swal('Nice!', 'Your card was added successfully!', 'success')}, 
        error => { swal('Oops!', 'Something went wrong!', 'error')},
        () => { console.log('completed') }
      )
    this.cardForm.reset(); 
  }
}
