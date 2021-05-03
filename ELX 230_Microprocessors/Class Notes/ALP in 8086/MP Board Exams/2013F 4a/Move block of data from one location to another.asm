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
    main proc
        .startup
        
        mov si,3000h
        mov di,4000h
        mov cx,06h
        repeat:
            mov al,[si]
            mov [di],al
            inc si
            inc di
            loop repeat
        
        main endp
    end main