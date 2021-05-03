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
        .startup 
        mov cx,number
        mov dx,0000h
        mov ax,0001h
        again:
            mul cx
            dec cx
            jnz again
        break:    
        
        mov result,ax
        
        main endp
    end main
            