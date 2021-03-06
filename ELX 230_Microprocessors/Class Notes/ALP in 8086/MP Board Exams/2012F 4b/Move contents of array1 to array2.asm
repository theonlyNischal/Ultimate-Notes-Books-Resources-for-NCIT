;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.model small
.stack 100h
.data
    array1 db 1,2,3,4,5,6,7,8,9,10
    array2 db 10 dup(?)

.code
    main proc
        .startup
        xor cx,cx
        mov cl,10
        lea si,array1
        lea di,array2
        
        repeat:
            mov al,[si]
            mov [di],al
            inc si
            inc di
            loop repeat
        
        mov ah,4ch
        int 21h
        
        main endp
    end main
    