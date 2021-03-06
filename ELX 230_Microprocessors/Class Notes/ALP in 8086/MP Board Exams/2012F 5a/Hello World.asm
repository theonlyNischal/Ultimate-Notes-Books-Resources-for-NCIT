;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    string db 'Hello World','$'

.code
    main proc
        .startup
        lea dx, string
        mov ah,09h
        int 21h
        
        mov ah,4ch
        int 21h
        
        main endp
    end main