;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    string db 'POKHARA UNIVERSITY','$'

.code
    display proc
        push ax
        mov ah,02h
        int 21h
        pop ax
        ret
        display endp

    main proc
        mov ax,@data
        mov ds,ax
        
        lea si,string
        xor cx,cx
        repeat:
            mov al,[si]
            cmp al,'$'
            je break
            inc si
            inc cl
            jmp repeat
        break:
        dec si
        again:
            mov dl,[si]
            call display
            dec si
            loop again
        main endp
    end main
    