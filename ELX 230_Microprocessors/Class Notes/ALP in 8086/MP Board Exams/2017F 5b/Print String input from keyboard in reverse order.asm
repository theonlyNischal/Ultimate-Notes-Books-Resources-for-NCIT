;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    string db 99 dup(?)
    count db 00h

.code
    display proc
        push dx
        mov ah,02h
        int 21h
        pop dx
        ret
        display endp
    
    main proc
        .startup
        
        lea si,string
        repeat:
            mov ah,01h
            int 21h
            cmp al,13
            je break
            mov [si],al
            inc si
            inc count
            jmp repeat
        break:
        xor cx,cx
        
        mov cl,count
        dec si
        again:
            mov dl,[si]
            call display
            dec si
            loop again
        main endp
    end main
    