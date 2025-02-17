import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { BookListComponent } from './book-list/book-list.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { NgModule } from '@angular/core';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { SubmitPageComponent } from './submit-page/submit-page.component';
import { BookHandlerComponent } from './book-handler/book-handler.component';
import { AuthGuard } from './guards/auth-guard.service';


export const routes: Routes = [

    {path: 'home-page', component: HomePageComponent},
    {path: 'book-list', component: BookListComponent, canActivate: [AuthGuard]},
    {path: 'book/:id', component: BookDetailComponent, canActivate: [AuthGuard]},
    {path: 'submit-page', component: SubmitPageComponent},
    {path: 'login', component: LoginPageComponent},
    {path: 'book-handler', component: BookHandlerComponent, canActivate: [AuthGuard]},
    {path: '', redirectTo: '/home-page', pathMatch: 'full'}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}