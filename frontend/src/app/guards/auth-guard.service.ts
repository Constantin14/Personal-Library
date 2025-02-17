import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from "@angular/router";
import { LoginPageService } from "../login-page/login-page.service";
import { userAccount } from "../user.global-model";

@Injectable({
    providedIn: 'root',
})
export class AuthGuard implements CanActivate {

    constructor(private loginService: LoginPageService, private router: Router) {

    }
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
        if (userAccount.isAuth) {
            return true;
        }
        this.router.navigate(['home-page']);
        return false;
    }
    
}