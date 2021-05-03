;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data

.code
    delay proc
        push cx
        mov cx,100
        again:
            nop
            nop
            loop again
        
        pop cx
        ret
        delay endp
    main proc
        mov ax,2000h
        mov ds,ax
        mov si,0000h
        mov cx,100
        repeat:
            call delay
            mov al,[si]
            out 00h,al
            inc si
            loop repeat        
        main endp
    end main
    