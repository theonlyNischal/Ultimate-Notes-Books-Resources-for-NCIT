title "Display all prime numbers less than 40"
;
;@author: bikalpa (@theoctober19th)
;10.17.2017 13:29:43 NPT

;Algorithm:
;divide every number from 1 to 40 by {2,3,5}
;if they aren't exactly divisible, they are primes
;for n<120, {2,3,5,7,11} works fine
;.dosseg
.stack
.model small
.data
    limit db 40
    divisors db 02,03,05
    space db '  $'

.code
    writespace proc                     ;A procedure to write ' ' space to the screen, which is to separate the numbers
        push dx
        push ax
        lea dx,space
        mov ah,09h
        int 21h
        pop ax
        pop dx
        ret
        
    displayacc proc                     ;This procedure displays whatever value there's on accumulator, by changing it to ASCII characters
        push ax
        push dx
        aam
        add ax,3030h
        mov dl,ah
        mov dh,al
        mov ah,02h
        int 21h
        mov dl,dh
        int 21h            
        pop dx
        pop ax
        call writespace
        ret
        
    main proc
        .startup
        xor cx,cx       ;clear the cx register
        mov cl,limit    ;now, initialize counter which is equal to the number n, where we have to find prime numbers < n
        
        again:          ;this loop executed for cx = 40, 39, ................... 01
             cmp cx,01  ;but, 01 is not a prime number(and if this line is missed, it prints 01 too)
             je last    ;if cx = 0, this means it is last iteration in loop. so go to 'last' label
             
             mov dx,cx  ;we now enter another nested loop where we redefine cx register. so store it to dx, and push it.
             push cx
             xor cx,cx
             mov cl,03  ;initialize cx with 03, for the second loop. (this is length of array of divisors)
             lea si,divisors
             
            inner:
                mov ax,dx; move the current number in 40, 39, ........... series in the dividend
                mov bl,[si]; choose the element in divisor array gradually as divisor 
                div bl
                cmp ah,0    ; after division, if remainder = 0, it means it is composite
                jne innerskip ; if this divisor doesn't confirm number is composite, lets divide the number by next divisor. goto innerskip to do so.
                    pop cx      ;retrieve the value of cx from stack(wherever it had reached in 40, 39, ...... series)
                    jmp skipdisplay ; and then goto label skipdisplay(because it is confirmed the number is composite)
                innerskip:
                inc si  ;increase the source index to move forth in divisor array
                loop inner ; this inner loop should be executed till the end of divisor array, or unless break as in line 62. 
            pop cx      ;retrieve the value of cx from stack(wherever it had reached in 40, 39, ...... series)      
            mov ax,cx  
            call displayacc ;move cx to ax, and then calling displayacc prints it in screen with space               
                
            skipdisplay:
            loop again    ;this loop should be continued till cx = 40, 39, ............. 01
        
        last:       ;now at last, after all other primes printed
        mov ax,05
        call displayacc     ;display 05
        mov ax,03
        call displayacc     ;display 03
        mov ax,02
        call displayacc     ;display 02    
        main endp
    end main
    
        