;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    number dw 0008h
    result dw 1 dup(?)     ;uninitialized variable to store result

.code 
        
    main proc 
        mov cx,8
        xor ax,ax
        xor dx,dx
        mov al,01h
        again:
            mul cx
            dec cx
            jz break
            jmp again
        break:    

        mov result,ax
        
        main endp
    end main
            