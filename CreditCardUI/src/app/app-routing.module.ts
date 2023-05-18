import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes),
            MatFormFieldModule,],
  exports: [RouterModule,
            MatFormFieldModule],
  providers: [
              {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}}
            ]
})
export class AppRoutingModule { }
