import {
    Component,
    Inject,
    OnDestroy,
    OnInit,
    PLATFORM_ID,
    afterNextRender,
    effect,
    model,
    signal,
  } from '@angular/core';
  import { millisecondsToMinutesSeconds } from '../../../core/util/util';
  import { isPlatformBrowser } from '@angular/common';
  
  const INIT_TIME = 'init-time';
  const FIVE_MINUTES_IN_MS = 60000;
  @Component({
    selector: 'app-countdown',
    standalone: true,
    imports: [],
    templateUrl: './countdown.component.html',
    styleUrl: './countdown.component.scss',
  })
  export class CountdownComponent implements OnInit, OnDestroy {
    interval!: NodeJS.Timeout;
    time = model<string>('', { alias: 'countDownTimer'});
    
    constructor(@Inject(PLATFORM_ID) private platformId: any) {
      effect(() => {
        if ( this.time() === '00:00') {
          clearInterval(this.interval)
          localStorage.removeItem(INIT_TIME)
        }
      })
    }
    ngOnInit(): void {
      if (isPlatformBrowser(this.platformId)) {
        this.interval = setInterval(() => {
          const timeInStorage = localStorage.getItem(INIT_TIME);
          if (timeInStorage !== null) {
            const timeElapsedSinceGettingOtp = Date.now() - Number(JSON.parse(timeInStorage!));
            const countdownTimer = FIVE_MINUTES_IN_MS - timeElapsedSinceGettingOtp;
            this.time.set(millisecondsToMinutesSeconds(countdownTimer));
            console.log(this.time());
          } else {
            localStorage.setItem(INIT_TIME, JSON.stringify(Date.now()));
          }
        }, 1000);
      }
    }
  
    ngOnDestroy(): void {
      clearInterval(this.interval);
    }
  }