;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    string db 'Pokhara University','$'

.code
    main proc
        mov ax,@data
        mov ds,ax
        
        lea si,string
        
        repeat:
            mov dl,[si]
            cmp dl,'$'
            je exitloop
            
            mov ah,02h
            int 21h
            
            inc si
            jmp repeat
        exitloop:
        main endp
    end main
    